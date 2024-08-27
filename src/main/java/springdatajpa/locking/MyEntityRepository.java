package springdatajpa.locking;

import java.util.Optional;

@Repository
public interface MyEntityRepository extends JpaRepository<MyEntity, Long> {

    /**
     * PESSIMISTIC_READ:
     * - Allows other transactions to read the entity, but prevents them from writing to it.
     * - Use this lock when you want to ensure that the data being read does not change
     *   during your transaction, but still allow others to read it.
     */
    @Lock(LockModeType.PESSIMISTIC_READ)
    Optional<MyEntity> findWithPessimisticReadLock(Long id);

    /**
     * PESSIMISTIC_WRITE:
     * - Prevents other transactions from reading or writing the entity.
     * - Use this lock when you need exclusive access to the entity during your transaction,
     *   ensuring that no other transaction can read or modify it until your transaction is complete.
     */
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<MyEntity> findWithPessimisticWriteLock(Long id);

    /**
     * PESSIMISTIC_FORCE_INCREMENT:
     * - Similar to PESSIMISTIC_WRITE, but also forces the version number of the entity to increment.
     * - Use this lock when you want to indicate that the entity was accessed and potentially modified,
     *   ensuring that future transactions detect that the entity has changed, even if no changes were made.
     */
    @Lock(LockModeType.PESSIMISTIC_FORCE_INCREMENT)
    Optional<MyEntity> findWithPessimisticForceIncrementLock(Long id);
}
