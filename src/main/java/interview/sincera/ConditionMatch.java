package interview.sincera;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConditionMatch {

  public static void main(String[] args) {
//    Map<String,> conditionsMap = new HashMap<>();
//    if (conditionsMap.containsKey("Country")) {
//      List<String> valueList = conditionsMap.get("Country");
//      if (valueList.contains("INDIA")) {
//
//      }
//    }
  }
class Group{
  List<Condition> conditionList;
  List<Assignment> assignmentList;
  private boolean isGroupConditionAccepted;
}
  class Condition {
    private String key;
    private String value;
    private boolean isConditionAccepted;
    private List<Assignment> assignment;

    void matchCondition() {
      //if condition is satisfied
      isConditionAccepted = true;
      initAssignment();
    }

    void initAssignment() {
    }
  }
  //initialize()
  //areConditionsMet()
  //action()

  class Assignment {
    String field;
    String value;
  }

  enum conditionKeys {
    country,
    state,
    city,
    pinCode
  }

  class Wrapper {

    List<String> valueList;
    Map<String, String> fieldList;
  }
}



//Condition A