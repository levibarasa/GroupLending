package com.sim.gls.service;

import com.sim.gls.jpa.Categories;
import com.sim.gls.manager.CRUD;
import com.sim.gls.manager.HibernateUtilHelper;
import com.sim.gls.model.Category;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Levi
 */
public class CategoryService {

    HibernateUtilHelper hibernateUtilHelper = new HibernateUtilHelper();
    CRUD crud = new CRUD(hibernateUtilHelper.getGLSHU());
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-YYYY", Locale.getDefault());
    private static final Log log = LogFactory.getLog("logger");

    /*
    Checks if Category exists
     */
    public boolean categoryExists(String categorycode, String categorytype) {
        String query = "from Categories where categorycode like '%" + categorycode + "%'"
                + "or categorytype like '%" + categorytype + "%'";
        List<Object> categoryList = crud.getObject(query);
        if (categoryList.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void addCategories(Category category) {
        Categories saved = new Categories(category.getBankId(), category.getBocreatedby(), category.getBodatecreated(), category.getBodatemodified(), category.getBomodifiedby(), category.getCategorycode(), category.getCategorytype(), category.getCategoryvalue());
        crud.save(saved);
    }

    public List<Category> getcategoriesDetails(String categorycode, String categorytype) {
        List<Category> allCategories = new LinkedList<>();
        String query = "from Categories where categorycode like '%" + categorycode + "%'"
                + "or categorytype like '%" + categorytype + "%'";
        List<Object> categoryList = crud.getObject(query);
        for (Object categoryObject : categoryList) {
            Categories categories = (Categories) categoryObject;
            Category category = new Category(categories.getBankId(), categories.getBocreatedby(), categories.getBodatecreated(), categories.getBodatemodified(),categories.getBomodifiedby(), categories.getCategorycode(), categories.getCategorytype(), categories.getCategoryvalue());
            categoryList.add(category);
  }
        return allCategories;
    }
    
    public List<Category> getCategories(String statuscategory) {
    List<Category> categList =new ArrayList<>();
    String query = "from Categories where categorytype like '%" + statuscategory + "%'"
                + "or categorytype like '%" + statuscategory + "%'";
        List<Object> categoryList = crud.getObject(query);
        for (Object categoryObject : categoryList) {
            Categories categories = (Categories) categoryObject;
            Category category = new Category(categories.getBankId(), categories.getBocreatedby(), categories.getBodatecreated(), categories.getBodatemodified(),categories.getBomodifiedby(), categories.getCategorycode(), categories.getCategorytype(), categories.getCategoryvalue());
            categoryList.add(category);
  }
    return categList;
    }

}
