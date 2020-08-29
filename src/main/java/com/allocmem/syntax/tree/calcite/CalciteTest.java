package com.allocmem.syntax.tree.calcite;

import org.apache.calcite.config.Lex;
import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql.SqlOrderBy;
import org.apache.calcite.sql.SqlSelect;
import org.apache.calcite.sql.dialect.OracleSqlDialect;
import org.apache.calcite.sql.parser.SqlParseException;
import org.apache.calcite.sql.parser.SqlParser;

public class CalciteTest {

    public static void main(String[] args) throws SqlParseException {
        // Sql语句
        String sql = "select * from users left join  b on user.a = b.a where dt > 32 and a < 12 order by id";
        // 解析配置
        SqlParser.Config mysqlConfig = SqlParser.configBuilder().setLex(Lex.MYSQL).build();
        // 创建解析器
        SqlParser parser = SqlParser.create(sql, mysqlConfig);
        // 解析sql
        SqlNode sqlNode = parser.parseQuery();
        // 还原某个方言的SQL
        System.out.println(sqlNode.toSqlString(OracleSqlDialect.DEFAULT));
//        System.out.println(sqlNode);
        System.out.println(((SqlSelect)(((SqlOrderBy) sqlNode).query)).getWhere().toString());
    }
}
