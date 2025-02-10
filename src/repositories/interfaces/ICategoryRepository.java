package repositories.interfaces;

import entities.Category;
import java.util.List;

public interface ICategoryRepository {
    boolean addCategory(Category category);
    boolean deleteCategory(int id);
    List<Category> getAllCategories();
}