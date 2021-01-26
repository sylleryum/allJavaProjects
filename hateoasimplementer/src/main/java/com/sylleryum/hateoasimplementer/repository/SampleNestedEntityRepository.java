package com.sylleryum.hateoasimplementer.repository;

import com.sylleryum.hateoasimplementer.entity.SampleNestedEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SampleNestedEntityRepository extends PagingAndSortingRepository<SampleNestedEntity, Long> {
}
