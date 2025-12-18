CategoryController
@RestController
@RequestMapping("/categories")
public class CategoryController {

    @PostMapping
    public Category create(@RequestBody Category c) {
        if(repo.existsByName(c.getName()))
            throw new RuntimeException("Duplicate category");
        return repo.save(c);
    }

    @GetMapping
    public List<Category> list() {
        return repo.findAll();
    }
}