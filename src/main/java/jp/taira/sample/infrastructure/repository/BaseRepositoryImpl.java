package jp.taira.sample.infrastructure.repository;

import jp.taira.sample.domain.repository.BaseRepository;

import java.util.List;

/**
 * BaseRepositoryImpl
 */
abstract class BaseRepositoryImpl<M, E> implements BaseRepository<M, E> {

    @Override
    public M findById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<M> findByEnabled() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public M toModel(E entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void transfer(M model, E entity) {
        // TODO Auto-generated method stub

    }

    @Override
    public E toDataModel(M model) {
        // TODO Auto-generated method stub
        return null;
    }
}
