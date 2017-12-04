package com.wz.VisoApp.appService.dao.impl;

import com.wz.VisoApp.appService.dao.TestDao;
import com.wz.VisoApp.appService.dao.base.impl.BaseDaoImpl;
import com.wz.VisoApp.common.util.BaseUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.jdbc.Work;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by chenwuxiong on 2017/11/30.
 */
@Repository
public class TestDaoImpl extends BaseDaoImpl implements TestDao {

    @Override
    public int updateList() {
        String sql = " insert into test VALUE (?,?)";
        Session session = this.getNewSession();
        Transaction  ts = session.beginTransaction();
        session.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                try{
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    for (int i = 0; i < 10; i++) {
                        preparedStatement.setString(1, BaseUtil.UUID());
                        preparedStatement.setString(2,String.valueOf(i));
                        preparedStatement.addBatch();
                    }
                    preparedStatement.executeBatch();
                    ts.commit();
                }catch (SQLException e){
                    e.printStackTrace();
                    ts.rollback();
                    session.close();
                    throw new SQLException(e);
                }

            }
        });
        session.close();
        return 10;
    }
}
