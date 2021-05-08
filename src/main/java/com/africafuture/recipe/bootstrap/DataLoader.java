package com.africafuture.recipe.bootstrap;

import com.africafuture.recipe.domain.Ingredient;
import com.africafuture.recipe.domain.Note;
import com.africafuture.recipe.domain.Recipe;
import com.africafuture.recipe.enums.Difficulty;
import com.africafuture.recipe.repository.CategoryRepository;
import com.africafuture.recipe.repository.RecipeRepository;
import com.africafuture.recipe.repository.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Set;

import static com.africafuture.recipe.utils.BigDecimalConstants.HALF;
import static com.africafuture.recipe.utils.BigDecimalConstants.QUARTER;
import static com.africafuture.recipe.utils.BigDecimalConstants.TWO;

@Component
public class DataLoader implements CommandLineRunner {
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;

    public DataLoader(UnitOfMeasureRepository unitOfMeasureRepository,
                      CategoryRepository categoryRepository, RecipeRepository recipeRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {
        Recipe spicyGrilledChickenTacos = new Recipe();
        spicyGrilledChickenTacos.setName("Spicy Grilled Chicken Tacos");
        spicyGrilledChickenTacos.setPrepTime(20);
        spicyGrilledChickenTacos.setCookTime(15);
        spicyGrilledChickenTacos.setServings(6);
        spicyGrilledChickenTacos.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        spicyGrilledChickenTacos.setDifficulty(Difficulty.MODERATE);
        spicyGrilledChickenTacos.setSource("Mexico");
        spicyGrilledChickenTacos.setShortDescription("Spicy grilled chicken tacos! Quick marinade, then grill. " +
                "Ready in about 30 minutes. ");
        spicyGrilledChickenTacos.setDescription("Great for a quick weeknight dinner, backyard cookouts, and tailgate parties." +
                "We have a family motto and it is this: Everything goes better in a tortilla." +
                "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. " +
                "I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house." +
                "Today's tacos are more purposeful – a deliberate meal instead of a secretive midnight snack!" +
                "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. " +
                "You can also use this time to prepare the taco toppings." +
                "Grill the chicken, then let it rest while you warm the tortillas. " +
                "Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!" +
                "The ancho chiles I use in the marinade are named for their wide shape. " +
                "They are large, have a deep reddish brown color when dried, and are mild in flavor with just a hint of heat. " +
                "You can find ancho chile powder at any markets that sell Mexican ingredients, or online." +
                "I like to put all the toppings in little bowls on a big platter at the center of the table: " +
                "avocados, radishes, tomatoes, red onions, wedges of lime, and a sour cream sauce. " +
                "I add arugula, as well – this green isn't traditional for tacos, but we always seem to have some in the fridge and I think it adds a nice green crunch to the tacos." +
                "Everyone can grab a warm tortilla from the pile and make their own tacos just they way they like them." +
                "You could also easily double or even triple this recipe for a larger party. " +
                "A taco and a cold beer on a warm day? Now that's living!");
        spicyGrilledChickenTacos.setNote(new Note("Look for ancho chile powder with the Mexican ingredients at your grocery store, on buy it online. " +
                "(If you can't find ancho chili powder, you replace the ancho chili, the oregano, and the cumin with 2 1/2 tablespoons regular chili powder, though the flavor won't be quite the same.)",
                spicyGrilledChickenTacos));
        spicyGrilledChickenTacos.setIngredients(Set.of(
                new Ingredient(BigDecimal.valueOf(2), unitOfMeasureRepository.findByName("Tablespoon").get(), "ancho chili powder", spicyGrilledChickenTacos),
                new Ingredient(BigDecimal.ONE, unitOfMeasureRepository.findByName("Teaspoon").get(), "dried oregano", spicyGrilledChickenTacos),
                new Ingredient(BigDecimal.ONE, unitOfMeasureRepository.findByName("Teaspoon").get(), "dried cumin", spicyGrilledChickenTacos),
                new Ingredient(BigDecimal.ONE, unitOfMeasureRepository.findByName("Teaspoon").get(), "sugar", spicyGrilledChickenTacos),
                new Ingredient(HALF, unitOfMeasureRepository.findByName("Tablespoon").get(), "salt", spicyGrilledChickenTacos),
                new Ingredient(BigDecimal.ONE, unitOfMeasureRepository.findByName("Clove").get(), "garlic, finely chopped", spicyGrilledChickenTacos),
                new Ingredient(BigDecimal.ONE, unitOfMeasureRepository.findByName("Tablespoon").get(), "finely grated orange zest", spicyGrilledChickenTacos),
                new Ingredient(BigDecimal.valueOf(3), unitOfMeasureRepository.findByName("Tablespoon").get(), "fresh-squeezed orange juice", spicyGrilledChickenTacos),
                new Ingredient(BigDecimal.valueOf(2), unitOfMeasureRepository.findByName("Tablespoon").get(), "olive oil", spicyGrilledChickenTacos),
                new Ingredient(BigDecimal.valueOf(6), unitOfMeasureRepository.findByName("None").get(), "skinless, boneless chicken thighs", spicyGrilledChickenTacos),
                new Ingredient(BigDecimal.valueOf(8), unitOfMeasureRepository.findByName("None").get(), "small corn tortillas", spicyGrilledChickenTacos),
                new Ingredient(BigDecimal.valueOf(3), unitOfMeasureRepository.findByName("Ounce").get(), " packed baby arugula ", spicyGrilledChickenTacos),
                new Ingredient(BigDecimal.valueOf(2), unitOfMeasureRepository.findByName("None").get(), "medium ripe avocados, sliced", spicyGrilledChickenTacos),
                new Ingredient(BigDecimal.valueOf(4), unitOfMeasureRepository.findByName("None").get(), "radishes, thinly sliced", spicyGrilledChickenTacos),
                new Ingredient(HALF, unitOfMeasureRepository.findByName("None").get(), "cherry tomatoes, halved", spicyGrilledChickenTacos),
                new Ingredient(QUARTER, unitOfMeasureRepository.findByName("None").get(), "red onion, thinly sliced", spicyGrilledChickenTacos),
                new Ingredient(BigDecimal.ONE, unitOfMeasureRepository.findByName("None").get(), "Roughly chopped cilantro", spicyGrilledChickenTacos),
                new Ingredient(HALF, unitOfMeasureRepository.findByName("Cup").get(), "sour cream thinned", spicyGrilledChickenTacos),
                new Ingredient(QUARTER, unitOfMeasureRepository.findByName("Cup").get(), "milk", spicyGrilledChickenTacos),
                new Ingredient(BigDecimal.ONE, unitOfMeasureRepository.findByName("None").get(), "lime, cut into wedges", spicyGrilledChickenTacos)
        ));
        spicyGrilledChickenTacos.setCategories(Set.of(
                categoryRepository.findByName("Mexican").get(),
                categoryRepository.findByName("Fast Food").get()
        ));
        spicyGrilledChickenTacos.setDirections("1. Prepare a gas or charcoal grill for medium-high, direct heat\n" +
                "2. Make the marinade and coat the chicken:\n" +
                "In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "3. Grill the chicken:\n" +
                "Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "\n" +
                "4. Warm the tortillas:\n" +
                "Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "\n" +
                "5. Assemble the tacos:\n" +
                "Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.");
        /*try {
            spicyGrilledChickenTacos.setImage(ImagesUtils.getBytesOf("classpath:images/spicyGrilledChickenTacos", "png"));
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        recipeRepository.save(spicyGrilledChickenTacos);


        Recipe guacamole = new Recipe();
        guacamole.setName("Guacamole");
        guacamole.setPrepTime(10);
        guacamole.setServings(4);
        guacamole.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        guacamole.setDifficulty(Difficulty.EASY);
        guacamole.setSource("Mexico");
        guacamole.setShortDescription("The best guacamole keeps it simple: " +
                "just ripe avocados, salt, a squeeze of lime, onions, chiles, cilantro, and some chopped tomato. " +
                "Serve it as a dip at your next party or spoon it on top of tacos for an easy dinner upgrade.");
        guacamole.setDescription("Guacamole! Did you know that over 2 billion pounds of avocados are consumed each year in the U.S.? (Google it.) " +
                "That's over 7 pounds per person. I'm guessing that most of those avocados go into what has become America's favorite dip, guacamole." +
                "The word \"guacamole\", and the dip, are both originally from Mexico, where avocados have been cultivated for thousands of years. " +
                "The name is derived from two Aztec Nahuatl words—ahuacatl (avocado) and molli (sauce)." +
                "All you really need to make guacamole is ripe avocados and salt. " +
                "After that, a little lime or lemon juice—a splash of acidity—will help to balance the richness of the avocado. " +
                "Then if you want, add chopped cilantro, chiles, onion, and/or tomato ." +
                "The trick to making perfect guacamole is using ripe avocados that are just the right amount of ripeness. " +
                "Not ripe enough and the avocado will be hard and tasteless. Too ripe and the taste will be off." +
                "Check for ripeness by gently pressing the outside of the avocado. " +
                "If there is no give, the avocado is not ripe yet and will not taste good. " +
                "If there is a little give, the avocado is ripe. If there is a lot of give, the avocado may be past ripe and not good. " +
                "In this case, taste test first before using." +
                "To slice open an avocado, cut it in half lengthwise with a sharp chef's knife and twist apart the sides. One side will have the pit. To remove it, you can do one of two things:" +
                "Method #1: Gently tap the pit with your chef's knife so the knife gets wedged into the pit. Twist your knife slightly to dislodge the pit and lift to remove. If you use this method, first protect your hand with a thick kitchen towel before proceeding.\n" +
                "Method #2: Cut the side with the pit in half again, exposing more of the pit. Use your fingers or a spoon to remove the pit" +
                "Once the pit is removed, just cut the avocado into chunks right inside the peel and use a spoon to scoop them out." +
                "Once you have basic guacamole down, feel free to experiment with variations including strawberries, peaches, pineapple, mangoes, even watermelon. " +
                "One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). You can get creative with homemade guacamole!" +
                "Simple Guacamole: The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "Quick guacamole: For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Don't have enough avocados? To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. " +
                "Purists may be horrified, but so what? It tastes great." +
                "Here Are a Few Other Guacamole Recipes to Try" +
                "Spicy Three-Chile Guacamole" +
                "Strawberry Guacamole" +
                "Guacamole with Charred Sweet Corn, Bacon, and Tomato" +
                "Copycat Chipotle Guacamole" +
                "Bacon and Blue Cheese Guacamole." +
                "Guacamole has a role in the kitchen beyond a party dip, of course. " +
                "It's great scooped on top of nachos and also makes an excellent topping or side for enchiladas, tacos, grilled salmon, or oven-baked chicken." +
                "Guacamole is great in foods, as well. Try mixing some guacamole into a tuna sandwich or your next batch of deviled eggs." +
                "Guacamole is best eaten right after it's made. Like apples, avocados start to oxidize and turn brown once they've been cut. " +
                "That said, the acid in the lime juice you add to guacamole can help slow down that process, and if you store the guacamole properly, " +
                "you can easily make it a few hours ahead if you are preparing for a party." +
                "The trick to keeping guacamole green is to make sure air doesn't touch it! " +
                "Transfer it to a container, cover with plastic wrap, and press down on the plastic wrap to squeeze out any air pockets. " +
                "Make sure any exposed surface of the guacamole is touching the plastic wrap, not air. " +
                "This will keep the amount of browning to a minimum." +
                "You can store the guacamole in the fridge this way for up to three days." +
                "If you leave the guacamole exposed to air, it will start to brown and discolor. " +
                "That browning isn't very appetizing, but the guacamole is still good. " +
                "You can either scrape off the brown parts and discard, or stir them into the rest of the guacamole.");
        guacamole.setNote(new Note("Be careful handling chiles if using. " +
                "Wash your hands thoroughly after handling and do not touch your eyes or the area near your eyes with your hands for several hours.",
                guacamole));
        guacamole.setIngredients(Set.of(
                new Ingredient(BigDecimal.valueOf(2), unitOfMeasureRepository.findByName("None").get(), "ripe avocados", guacamole),
                new Ingredient(QUARTER, unitOfMeasureRepository.findByName("Teaspoon").get(), "salt, more to taste", guacamole),
                new Ingredient(BigDecimal.ONE, unitOfMeasureRepository.findByName("Tablespoon").get(), "fresh lime juice or lemon juice", guacamole),
                new Ingredient(QUARTER, unitOfMeasureRepository.findByName("Cup").get(), "minced red onion or thinly sliced green onion", guacamole),
                new Ingredient(BigDecimal.valueOf(2), unitOfMeasureRepository.findByName("None").get(), "serrano chiles, stems and seeds removed, minced", guacamole),
                new Ingredient(TWO, unitOfMeasureRepository.findByName("Tablespoon").get(), "cilantro (leaves and tender stems), finely chopped", guacamole),
                new Ingredient(BigDecimal.ONE, unitOfMeasureRepository.findByName("Dash").get(), "freshly grated black pepper", guacamole),
                new Ingredient(HALF, unitOfMeasureRepository.findByName("None").get(), "ripe tomato, seeds and pulp removed, chopped", guacamole),
                new Ingredient(BigDecimal.valueOf(6), unitOfMeasureRepository.findByName("None").get(), "Red radishes or jicama, to garnish", guacamole),
                new Ingredient(BigDecimal.ONE, unitOfMeasureRepository.findByName("None").get(), "Tortilla chips, to serve", guacamole)
        ));
        guacamole.setCategories(Set.of(
                categoryRepository.findByName("Mexican").get(),
                categoryRepository.findByName("Fast Food").get()
        ));
        guacamole.setDirections("1. Cut the avocado, remove flesh:\n" +
                "Cut the avocados in half. Remove the pit. " +
                "Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
                "2. Mash with a fork:\n" +
                "Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "3. Add salt, lime juice, and the rest:\n" +
                "Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n" +
                "\n" +
                "4. Serve:\n" +
                "Serve immediately, or if making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.");
        /*try {
            guacamole.setImage(ImagesUtils.getBytesOf("classpath:images/guacamole", "png"));
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        recipeRepository.save(guacamole);
    }
}
