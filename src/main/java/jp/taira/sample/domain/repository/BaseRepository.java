package jp.taira.sample.domain.repository;

import java.util.List;

/**
 * BaseRepository
 */
public interface BaseRepository<M, E> {

    M findById(Long id);

    List<M> findByEnabled();

    /**
     * ドメインモデルオブジェクトに変換する。
     *
     * @param entity データモデルオブジェクト
     * @return ドメインモデルオブジェクト
     */
    M toModel(E entity);

    /**
     * ドメインモデルオブジェクトからデータモデルオブジェクトに移し替える。
     *
     * @param model ドメインモデルオブジェクト
     * @param entity データモデルオブジェクト
     */
    void transfer(M model, E entity);

    /**
     * データモデルオブジェクトに変換する。
     *
     * @param model ドメインモデルオブジェクト
     * @return データモデルオブジェクト
     */
    E toDataModel(M model);

}
