package com.mymyyy.recipe;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.mymyyy.recipe.Recipe;

@Repository
public interface RecipeRepository extends MongoRepository<Recipe, Long> {

    /**
     * ObjectId検索
     * 
     * @param id ObjectId
     * @return 検索結果
     */
    public Recipe findById(String id);

    /**
     * メニュー名あいまい検索
     * 
     * @param str 検索ワード
     * @return 検索結果
     */
    public List<Recipe> findByNameLike(String str);

    /**
     * タグ名あいまい検索
     * 
     * @param str 検索ワード
     * @return 検索結果
     */
    public List<Recipe> findByTagLike(String str);

    /**
     * 材料名あいまい検索
     * 
     * @param str 検索ワード
     * @return 検索結果
     */
    public List<Recipe> findByIngredientsLike(String str);

}