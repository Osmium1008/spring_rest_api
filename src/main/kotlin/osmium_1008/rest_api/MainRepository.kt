package osmium_1008.rest_api

import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.core.simple.SimpleJdbcInsert
import org.springframework.stereotype.Repository

@Repository
class MainRepository(private val jdbcTemplate: NamedParameterJdbcTemplate) {
    private val rowMapper = RowMapper<Data>{rs, _ -> Data(rs.getInt("dat"),rs.getInt("id"))}

    fun push(dat:Data){
        val param=BeanPropertySqlParameterSource(dat);
        val insert= SimpleJdbcInsert(jdbcTemplate.jdbcTemplate).withTableName("dat").usingGeneratedKeyColumns("id");
        insert.execute(param)
    }

    fun getAll(): List<Data>{
        val query = "select * from dat"
        val ret = jdbcTemplate.query(query,rowMapper)
        return ret
    }
}

