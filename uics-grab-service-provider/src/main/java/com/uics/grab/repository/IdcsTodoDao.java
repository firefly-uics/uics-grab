package com.uics.grab.repository;

import com.uics.grab.entity.IdcsTodo;
import org.dubbo.x.repository.DaoBase;

/**
 * idcs代办
* Created by tom on 2016-12-07 14:34:59.
 **/
public interface IdcsTodoDao extends DaoBase<IdcsTodo> {
    IdcsTodo findByTodoId(String todoId);
}
