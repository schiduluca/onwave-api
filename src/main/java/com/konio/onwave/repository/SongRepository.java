package com.konio.onwave.repository;

import com.konio.onwave.domain.entities.SongEntity;
import com.konio.onwave.domain.views.SongView;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lschidu on 2/14/17.
 */
public interface SongRepository extends JpaRepository<SongEntity, SongView> {

    SongEntity findOneById(Long id);

    Long removeById(Long id);
}
