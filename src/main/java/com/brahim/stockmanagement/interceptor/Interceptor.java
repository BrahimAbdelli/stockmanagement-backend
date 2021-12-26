package com.brahim.stockmanagement.interceptor;

import org.hibernate.EmptyInterceptor;
import org.slf4j.MDC;
import org.springframework.util.StringUtils;

public class Interceptor extends EmptyInterceptor {

  @Override
  public String onPrepareStatement(String sql) {
    if (StringUtils.hasLength(sql) && sql.toLowerCase().startsWith("select")) {
        if (sql.contains("where")) {
          sql = sql + " and idCompany = 1 " ;
        } else {
          sql = sql + " where idCompany = 1 " ;
        }
    }
    return super.onPrepareStatement(sql);
  }
}
