package pl.damianlebiedz.financemanager;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/data")
public class MainController {

    final
    MainRepository mainRepository;

    public MainController(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

    @GetMapping("")
    public List<MyData> getAll() {
        return mainRepository.getAll();
    }

    @GetMapping("/{id}")
    public MyData getById(@PathVariable("id") int id) {
        return mainRepository.getById(id);
    }

    @PostMapping("")
    public int add(@RequestBody List<MyData> myData) {
        return mainRepository.save(myData);
    }
}
