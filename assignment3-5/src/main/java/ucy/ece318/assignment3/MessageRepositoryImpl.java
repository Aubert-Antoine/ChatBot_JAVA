package ucy.ece318.assignment3;

import java.util.Optional;

public class MessageRepositoryImpl implements MessageRepository {
    @Override
    public <S extends Message> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Message> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Message> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Message> findAll() {
        return null;
    }

    @Override
    public Iterable<Message> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Message entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Message> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
