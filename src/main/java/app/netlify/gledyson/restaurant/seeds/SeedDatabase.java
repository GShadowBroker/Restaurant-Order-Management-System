package app.netlify.gledyson.restaurant.seeds;

import app.netlify.gledyson.restaurant.model.Customer;
import app.netlify.gledyson.restaurant.model.Item;
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

    private final Logger log = LoggerFactory.getLogger(SeedDatabase.class);

    @Bean
    CommandLineRunner run(
            CustomerRepository customerRepository,
            ItemRepository itemRepository) {
        return args -> {

            log.info("Seeding database...");

            // ITEMS
            Item camarao = new Item(
                    "0377E",
                    "Camarão em Crosta",
                    "Camarões em crosta de pão de alho. Acompanha salada de alface americana, tomate, azeitona verde, palmito, pimentão e cebola. Acompanha e risoto de limão siciliano.",
                    "https://cocobambu.com/wp-content/uploads/2021/04/card-cam-camarao-em-crosta.jpeg",
                    3990
            );

            Item paillard = new Item(
                    "0378R",
                    "Paillard de Frango",
                    "400g de filé de frango grelhado sobre espaguete italiano e folhas de espinafre, servido com molho de limão siciliano.",
                    "https://cocobambu.com/wp-content/uploads/2021/04/card-fran-paillard_frango.jpeg",
                    7990
            );

            Item escondidinho = new Item(
                    "1854E",
                    "Escondidinho de Bacalhau",
                    "Bacalhau desfiado e refogado com cebola, azeitona preta, coentro, nata e molho bechamel. Coberto com purê de batata e gratinado com queijo parmesão.",
                    "https://cocobambu.com/wp-content/uploads/2021/04/card-esc-escondidinho-de-bacalhau.jpeg",
                    3990
            );

            Item salada = new Item(
                    "8801E",
                    "Salada Tropical",
                    "10 camarões grelhados, folhas verdes, manga, tomate cereja, cenoura e castanha de caju. Temperada com molho especial com tomate e azeite.",
                    "https://cocobambu.com/wp-content/uploads/2021/04/cardapio-salada-tropical.jpeg",
                    1190
            );

            Item gateau = new Item(
                    "0366E",
                    "Petit Gateau de Amêndoas e Limão Siciliano",
                    "Bolinho quente de amêndoas, com recheio de chocolate branco e coberto com raspas de limão siciliano. Acompanha sorvete de creme.",
                    "https://cocobambu.com/wp-content/uploads/2021/04/card-sobr-petit-de-amendoas-e-limao.jpeg",
                    790
            );

            // CUSTOMERS
            Customer maria = new Customer("Maria", "Silva", List.of());
            Customer joao = new Customer("João", "Santos", List.of());
            Customer ana = new Customer("Ana", "Paula", List.of());

            itemRepository.saveAll(
                    List.of(camarao, paillard, escondidinho, salada, gateau)
            );
            customerRepository.saveAll(List.of(maria, joao, ana));
        };
    }

}
