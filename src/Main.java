//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import controllers.ProductController;
import controllers.interfaces.IProductController;
import data.PostgresDB;
import data.interfaces.IDB;
import repositories.ProductRepository;
import repositories.interfaces.IProductRepository;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        IDB db = new PostgresDB();
        IProductRepository repo = new ProductRepository(db);
        IProductController controller = new ProductController(repo);
        MyApplication app = new MyApplication(controller);
        app.start();
    }
}
