public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsByName(String name);
}