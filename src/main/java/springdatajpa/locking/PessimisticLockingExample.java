//package springdatajpa.locking;
//
//import java.util.Optional;
//
//public class PessimisticLockingExample {
//
//    private final MyEntityRepository myEntityRepository;
//
//    public PessimisticLockingExample(MyEntityRepository myEntityRepository) {
//        this.myEntityRepository = myEntityRepository;
//    }
//
//    // Method demonstrating PESSIMISTIC_READ lock usage
//    public void examplePessimisticReadLock(Long id) {
//        Optional<MyEntity> entity = myEntityRepository.findWithPessimisticReadLock(id);
//        entity.ifPresent(e -> {
//            // Business logic with the entity, knowing it cannot be modified by other transactions
//            System.out.println("Entity with PESSIMISTIC_READ lock: " + e.getSomeValue());
//        });
//    }
//
//    // Method demonstrating PESSIMISTIC_WRITE lock usage
//    public void examplePessimisticWriteLock(Long id) {
//        Optional<MyEntity> entity = myEntityRepository.findWithPessimisticWriteLock(id);
//        entity.ifPresent(e -> {
//            // Business logic with the entity, knowing it is locked for exclusive access
//            e.setSomeValue("Updated Value");
//            myEntityRepository.save(e);
//            System.out.println("Entity updated with PESSIMISTIC_WRITE lock");
//        });
//    }
//
//    // Method demonstrating PESSIMISTIC_FORCE_INCREMENT lock usage
//    public void examplePessimisticForceIncrementLock(Long id) {
//        Optional<MyEntity> entity = myEntityRepository.findWithPessimisticForceIncrementLock(id);
//        entity.ifPresent(e -> {
//            // Business logic with the entity, knowing the version will be incremented
//            System.out.println("Entity with PESSIMISTIC_FORCE_INCREMENT lock: " + e.getSomeValue());
//        });
//    }
//}
