package com.mymyyy.recipe;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.mymyyy.recipe.RecipeRepository;

@Controller
@RequestMapping("/")
public class ApplicationController {

    @Autowired
    RecipeRepository repository;

    /**
     * レシピ一覧表示
     * 
     * @param mav ModelAndView
     * @return ModelAndView
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView menu(ModelAndView mav) {

        // TODO: レシピ投稿機能実装

        mav.setViewName("recipeList");
        mav.addObject("title", "全件表示");

        // レシピ一覧取得
        List<Recipe> recipeList = repository.findAll();
        mav.addObject("recipeList", recipeList);

        return mav;
    }

    /**
     * レシピ検索結果表示
     * 
     * @param mav ModelAndView
     * @return ModelAndView
     */
    @RequestMapping(value = "search", method = RequestMethod.GET)
    public ModelAndView search(ModelAndView mav, @RequestParam("criteria") String criteria,
            @RequestParam("q") String word) {

        // TODO: 検索方法変更(複数キーワード対応)

        mav.setViewName("recipeList");
        mav.addObject("title", "検索結果");

        Iterable<Recipe> recipeList;

        // メニュー名検索
        if (criteria.equals("menu")) {
            recipeList = repository.findByNameLike(word);
        }
        // タグ検索
        else if (criteria.equals("tag")) {
            recipeList = repository.findByTagLike(word);
        }
        // 材料検索
        else {
            recipeList = repository.findByIngredientsLike(word);
        }

        mav.addObject("recipeList", recipeList);

        return mav;
    }

    /**
     * 文字列を改行箇所で分割
     * 
     * @param str 分割する文字列
     * @return 分割後の配列
     */
    public static String[] splitLines(String str) {
        return str.split("\r\n|\r|\n");
    }

    /**
     * レシピ表示
     * 
     * @param mav ModelAndView
     * @return ModelAndView
     */
    @RequestMapping(value = "menu/{id}", method = RequestMethod.GET)
    public ModelAndView recipe(ModelAndView mav, @PathVariable(name = "id") String id) {

        // TODO: レシピ編集機能実装

        mav.setViewName("recipe");

        // ID検索でレシピ取得
        Recipe recipe = repository.findById(id);
        mav.addObject("recipe", recipe);

        return mav;
    }

}