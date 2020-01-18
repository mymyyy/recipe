package com.mymyyy.recipe;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

public class Recipe {

    /** ObjectId */
    @Id
    private String id;

    /** レシピ名 */
    @NotNull
    private String name;
    /** タグ(カンマ区切りで記載) */
    @NotNull
    private String tag;
    /** 何人前 */
    @NotNull
    private String serve;
    /** 材料 */
    @NotNull
    private String ingredients;
    /** 手順 */
    @NotNull
    private String instructions;

    public Recipe(String name, String tag, String serve, String ingredients, String instructions) {
        super();

        this.name = name;
        this.tag = tag;
        this.serve = serve;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    /**
     * ObjectIdを取得
     * 
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * レシピ名を取得
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * タグを取得
     * 
     * @return tag
     */
    public String getTag() {
        return tag;
    }

    /**
     * 何人前のレシピか取得
     * 
     * @return serve
     */
    public String getServe() {
        return serve;
    }

    /**
     * 材料を取得
     * 
     * @return ingredients
     */
    public String getIngredients() {
        return ingredients;
    }

    /**
     * 手順を取得
     * 
     * @return instructions
     */
    public String getInstructions() {
        return instructions;
    }
}