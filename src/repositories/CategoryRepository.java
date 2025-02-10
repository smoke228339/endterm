package repositories;

import data.interfaces.IDB;
import entities.Category;
import repositories.interfaces.ICategoryRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements ICategoryRepository {
    private final IDB db;

    public CategoryRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean addCategory(Category category) {
        String query = "INSERT INTO categories (name) VALUES (?)";
        try (Connection con = db.getConnection(); PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, category.getName());
            return stmt.executeUpdate() > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean deleteCategory(int id) {
        String sql = "DELETE FROM categories WHERE id = ?";
        Connection connection = null;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public List<Category> getAllCategories() {
        String query = "SELECT * FROM categories";
        List<Category> categories = new ArrayList<>();
        try (Connection con = db.getConnection(); Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                categories.add(new Category(rs.getInt("id"), rs.getString("name")));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return categories;
    }
}