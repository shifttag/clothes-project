package com.a1.a1.repository;

import com.a1.a1.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Integer> {

    CartEntity findByCartId(Long cartId);
    CartEntity findByUserIdAndProductId(Long userId, Long productId);

    void deleteByCartId(Long cartId);

    List<CartEntity> findByUserId(Long userId);

}
