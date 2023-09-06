package pl.damianlebiedz.financemanager;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MainRepository {

    final
    JdbcTemplate jdbcTemplate;

    public MainRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<MyData> getAll() {
        return jdbcTemplate.query("SELECT * FROM data",
                BeanPropertyRowMapper.newInstance(MyData.class));
    }

    public MyData getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM data WHERE id = ?",
                BeanPropertyRowMapper.newInstance(MyData.class), id);
    }

    public int save(List<MyData> myData) {
        myData.forEach(data -> jdbcTemplate
                .update("INSERT INTO data(name, category, price) VALUES(?, ?, ?)",
                        data.getName(), data.getCategory(), data.getPrice()
                ));
        return 1;
        //TODO/NOT-WORKING
    }
}
