package com.goat.service;

import com.goat.domain.MyMoney;
import com.goat.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


/**
 * Created by 64274 on 2018/9/14.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/9/14---16:17
 */
@Service
public class TestService extends BaseService {

    @Autowired
    TestRepository testRepository;

    public Optional<MyMoney> findById(Long id) {
        return testRepository.findById(id);
    }

    /**
     * 在更新数据时，jpa 提供的 两个方法  可以实现 @version 字段的自增+1
     <S extends T> S save(S var1);
     <S extends T> Iterable<S> saveAll(Iterable<S> var1);
     * */
    @Transactional
    public void mySave(MyMoney myMoney) {
        testRepository.save(myMoney);
         throw new RuntimeException("hahaha"); // sos 这里抛出异常 为啥不能回滚？  解决：因为表引擎不是 InnoDB 而是 MyISAM ！
    }

    @Transactional
    public void save1(MyMoney myMoney) {
        super.save(myMoney);
    }

    /** 如果是自己写的update方法，下面这样，是不生效的 比如这样： @Query("UPDATE MyMoney SET col1 = :num WHERE id = :id")
        需要 改成这样：@Query("UPDATE MyMoney SET col1 = :num,version=version+1 WHERE id = :id and version=:version ")
        输了一瓶脉动 得到的教训啊。。。
     * * */
    @Transactional
    public void update(String num,Long id,Long version) {
        testRepository.updateMoney(num,id,version);
    }

    @Transactional
    public void update2(String num,Long id,Long version) {
        testRepository.updateMoney2(num,id,version);
    }
}


//@Query(value = "UPDATE user SET age = if(age is null,0,age) + :age WHERE id = :id",nativeQuery = true)