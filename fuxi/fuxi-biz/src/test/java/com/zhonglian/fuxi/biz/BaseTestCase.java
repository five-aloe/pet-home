/**
 * Copyright (c) 2017, 满兜 . All rights reserved. Use is subject to license terms.
 */
package com.zhonglian.fuxi.biz;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhonglian.fuxi.biz.config.SpringBizConfigs;
import com.zhonglian.fuxi.dal.config.SpringDalConfigs;

/**
 * @author zyf
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {TestApplication.class, SpringDalConfigs.class, SpringBizConfigs.class})
@Transactional
@Rollback
public class BaseTestCase  {

}
