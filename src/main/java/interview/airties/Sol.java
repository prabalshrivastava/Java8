package interview.airties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Sol {

  public static void main(String[] args) {

  }
}

class Device {

  String deviceId;
  String deviceName;
  String mac;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Device device = (Device) o;

    return this.mac.equals(((Device) o).mac);
  }
}

class Event {

  String eventId;
  String deviceId;
  String eventDetail;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Event event = (Event) o;

    return this.eventId.equals(((Event) o).eventId);
  }

  @Override
  public int hashCode() {
    return eventId.hashCode();
  }
}


interface PartnerServiceAdapter {

  List<Event> map(List<Device> devicesFromPartner1, List<Device> devicesFromPartner2,
      List<Event> eventListFromPartner2);
}

class AirtiesService implements PartnerServiceAdapter {

  @Override
  public List<Event> map(List<Device> devicesFromPartner1, List<Device> devicesFromPartner2,
      List<Event> eventListFromPartner2) {

    Map<Event, Device> filteredMap = new HashMap<>();
    for (int i = 0; i < eventListFromPartner2.size(); i++) {
      String deviceId = eventListFromPartner2.get(i).deviceId;

      for (int j = 0; j < devicesFromPartner2.size(); j++) {
        if (devicesFromPartner2.get(j).deviceId.equals(deviceId)) {
          filteredMap.put(eventListFromPartner2.get(i), devicesFromPartner2.get(j));
        }
      }
    }

//    devicesFromPartner1.stream().filter(filteredMap::containsValue)
    return filteredMap.entrySet()
        .stream()
        .filter(eventDeviceEntry -> devicesFromPartner1.contains(eventDeviceEntry.getValue()))
        .map(Entry::getKey)
        .collect(Collectors.toList());
  }
}

//CustomerCareUI calling airties with homeId and airties calls the pertners and gets the list of devices.
//Options to see the events that are generated in the home with deviceId as a field(which generated the event)
//when we query the same partner the deviceId is found but not across partners since the deviceId is different in partners.