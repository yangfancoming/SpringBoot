package com.goat.repository;

import com.goat.domain.Pet;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by 64274 on 2018/9/28.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/9/28---17:21
 *
 * Customer 实体类
 * Long 主键ID 类型
 */
public interface PetRepository extends CrudRepository<Pet, Long> {

}
