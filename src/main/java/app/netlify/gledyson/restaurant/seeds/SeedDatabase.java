package app.netlify.gledyson.restaurant.seeds;

import app.netlify.gledyson.restaurant.model.Item;
import app.netlify.gledyson.restaurant.repository.CustomerOrderRepository;
import app.netlify.gledyson.restaurant.repository.CustomerRepository;
import app.netlify.gledyson.restaurant.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SeedDatabase {

    Logger log = LoggerFactory.getLogger(SeedDatabase.class);

    @Bean
    CommandLineRunner run(
            CustomerRepository customerRepository,
            CustomerOrderRepository orderRepository,
            ItemRepository itemRepository) {
        return args -> {

            log.info("Seeding database...");

            Item bananaBeef = new Item(
                    "Banana Beef Pudding",
                    "Restores 0 health and 0 mana over 20 sec. Must remain seated while eating. If you spend at least 10 seconds eating you will become well fed and gain 0 Stamina for 60 min.",
                    "https://icons.wowdb.com/retail/large/inv_cooking_90_bananabeefpudding.jpg?40593",
                    3990
            );

            Item iridescentRavioli = new Item(
                    "Iridescent Ravioli with Apple Sauce",
                    "Restores 0 health and 0 mana over 20 sec. Must remain seated while eating. If you spend at least 10 seconds eating you will become well fed and gain 0 Mastery for 60 min.",
                    "https://icons.wowdb.com/retail/large/inv_cooking_90_crawlerravioliapplesauce.jpg?40593",
                    7990
            );

            Item darkhavenStout = new Item(
                    "Darkhaven Stout",
                    "A strong alcoholic beverage.",
                    "https://icons.wowdb.com/retail/large/spell_misc_drink.jpg?40593",
                    790
            );

            itemRepository.saveAll(
                    List.of(bananaBeef, iridescentRavioli, darkhavenStout)
            );
        };
    }

}
