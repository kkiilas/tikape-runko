
package pakkaus;

import java.util.HashMap;
import java.util.List;
import spark.ModelAndView;
import spark.Spark;
import static spark.Spark.get;
import static spark.Spark.post;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Database database = new Database("jdbc:sqlite:data.db");
        RaakaAineDao raakaAineDao = new RaakaAineDao(database);
        JuomaDao juomaDao = new JuomaDao(database);
        JuomaRaakaAineDao juomaRaakaAineDao = new JuomaRaakaAineDao(database);
        
        get("/", (req, res) -> {
            HashMap map = new HashMap<>();
            map.put("viesti", "Moi!");
            
            return new ModelAndView(map, "index");
        }, new ThymeleafTemplateEngine());
        
        get("/juomat", (req, res) -> {
            HashMap map = new HashMap<>();
            List lista = juomaDao.findAll();
            map.put("lista", lista);

            return new ModelAndView(map, "juomat");
        }, new ThymeleafTemplateEngine());
        
        post("/juomat", (req, res) -> {
            
            String uudenJuomanNimi = req.queryParams("nimi");
            String vo = req.queryParams("valmistusohje");
            int uudenAineksenId = raakaAineDao.vapaaId();
            Juoma uusi = new Juoma(uudenAineksenId, uudenJuomanNimi, vo);
            Juoma a = juomaDao.saveOrUpdate(uusi);
            res.redirect("/");
            return "";
        });
        
        
        get("/raakaAineet", (req, res) -> {
            HashMap map = new HashMap<>();
            
            List lista = raakaAineDao.findAll();
            map.put("lista", lista);

            return new ModelAndView(map, "raakaAineet");
        }, new ThymeleafTemplateEngine());
        
        
        post("/raakaAineet", (req, res) -> {
            
            String uudenAineksenNimi = req.queryParams("nimi");
            int uudenAineksenId = raakaAineDao.vapaaId();
            RaakaAine uusi = new RaakaAine(uudenAineksenId, uudenAineksenNimi);
            RaakaAine a = raakaAineDao.saveOrUpdate(uusi);
            res.redirect("/raakaAineet");
            return "";
        });
        
        
        get("/juomat/:id", (req, res) -> {
            HashMap map = new HashMap<>();
            map.put("juoma", juomaDao.findOne(Integer.parseInt(req.params("id"))));

            return new ModelAndView(map, "juoma");
        }, new ThymeleafTemplateEngine());
        
    }
}
