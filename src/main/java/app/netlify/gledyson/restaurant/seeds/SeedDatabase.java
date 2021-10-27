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

            Item pastelPalmito = new Item(
                    "1377E",
                    "Pastel de Palmito",
                    "Massa fresca recheada com rodelas de palmito picadas. Refogado com pimentões e catupiry.",
                    "https://cocobambu.com/wp-content/uploads/2021/04/cardapio-pastel-palmito.jpeg",
                    1390
            );

            Item pasteFile = new Item(
                    "0987R",
                    "Pastel de Filé Mignon",
                    "Massa fresca recheada com filé mignon picadinho, temperado e refogado.",
                    "https://cocobambu.com/wp-content/uploads/2021/04/cardapio-pastel-file-mignon.jpeg",
                    1990
            );

            Item tilapia = new Item(
                    "6111R",
                    "Tilápia à Parmegiana",
                    "Filé de Tilápia empanado com molho de tomates frescos sobre espaguete. Gratinado com queijo muçarela.",
                    "https://cocobambu.com/wp-content/uploads/2021/04/card-peixe-tilapia-a-parmegiana.jpeg",
                    8990
            );

            Item cookie = new Item(
                    "0042E",
                    "Cookie com Sorvete",
                    "Cookie americano com pedacinhos derretidos de chocolate. Acompanha sorvete de creme.",
                    "https://cocobambu.com/wp-content/uploads/2021/04/card-sobr-cookie-sorvete.jpeg",
                    2290
            );

            Item pave = new Item(
                    "9832E",
                    "Torta Pavê de Chocolate Truffada",
                    "Torta com deliciosas camadas de pão de ló de chocolate trufado e creme de chocolate. Coberta com trufa cremosa e bolinhas de chocolate crocante.",
                    "https://cocobambu.com/wp-content/uploads/2021/04/card-tor-torta-pave-trufada-inteiro.jpeg",
                    6590
            );

            Item lasanha = new Item(
                    "9331R",
                    "Lasanha de berinjela",
                    "VEGETARIANO - Berinjelas empanadas envolvidas em molho de tomate fresco. Finalizadas ao forno com queijos mussarela e parmesão.",
                    "https://cocobambu.com/wp-content/uploads/2021/04/card-die-lasanha-de-beringela.jpeg",
                    4690
            );

            Item burger = new Item(
                    "4044R",
                    "Cheeseburguer com Fritas",
                    "Hambúrguer de corte premium, bacon, queijo, alface americana, tomate, cebola caramelizada e delicioso molho da casa servidos em um espetacular pão brioche. Acompanha batata frita.",
                    "https://cocobambu.com/wp-content/uploads/2021/04/card-hamb-cheeseburguer-com-batata.jpeg",
                    4490
            );

            Item arroz = new Item(
                    "1115E",
                    "Arroz de Polvo Caldoso",
                    "Delicioso arroz de polvo caldoso com batatas noisettes, cebola, alho, pimentão, molho de tomate fresco e molho reduzido do próprio polvo.",
                    "https://cocobambu.com/wp-content/uploads/2021/04/card-frut-polvo-caldoso.jpeg",
                    6790
            );

            Item cocktail = new Item(
                    "0199R",
                    "Coquetel de Camarão",
                    "6 camarões grandes servidos em taça com molho taíba (molho rosé especial da casa com especiarias)",
                    "https://cocobambu.com/wp-content/uploads/2021/04/card-pet-coquetel-de-camarao.jpeg",
                    3190
            );

            Item fritas = new Item(
                    "1974E",
                    "Filé com Fritas",
                    "Cubos de filé, refogado com cebola roxa e molho barbecue. Acompanha batata frita.",
                    "https://cocobambu.com/wp-content/uploads/2021/04/card-pet-file-com-fritas.jpeg",
                    1990
            );

            Item polvo = new Item(
                    "5425R",
                    "Polvo ao Azeite de Tomates Secos",
                    "Polvo em cubos refogados no azeite com cebola alho, pasta de tomate seco, parmesão e castanha de caju. Acompanha 6 pãezinhos.",
                    "https://cocobambu.com/wp-content/uploads/2021/04/card-pet-polvo-ao-azeite-de-tomates-secos.jpeg",
                    5990
            );

            Item saladaOriental = new Item(
                    "3008R",
                    "Salada Oriental",
                    "Mix de folhas verdes, palmito, tomates cereja, camarões e cogumelos shitake com molho vinagrete especial.",
                    "https://cocobambu.com/wp-content/uploads/2021/04/cardapio-salada-oriental.jpeg",
                    1990
            );

            Item pizza = new Item(
                    "7723E",
                    "Pizza de Calabresa com Catupiry",
                    "Pizza de Calabresa com Catupiry. Tem calabreza, e tem catupiry.",
                    "https://cocobambu.com/wp-content/uploads/2021/04/cardapio-pizza-de-calabresa-com-catupiry.jpeg",
                    6990
            );

            Item peixada = new Item(
                    "2760E",
                    "Peixada Cearense",
                    "Filé de peixe, tomate, cebola, pimentões, leite de coco, batatas, cenouras, repolho e ovos cozidos. Acompanha pirão e arroz branco.",
                    "https://cocobambu.com/wp-content/uploads/2021/04/card-peixe-peixada-cearense.jpeg",
                    7990
            );

            Item bolo = new Item(
                    "8810E",
                    "Bolo Quente",
                    "Bolo Quente de Chocolate com Brigadeiro mole e Creme Inglês.",
                    "https://cocobambu.com/wp-content/uploads/2021/04/card-sobr-bolo-quente.jpeg",
                    2690
            );

            // CUSTOMERS
            Customer maria = new Customer("Maria", "Silva", List.of());
            Customer joao = new Customer("João", "Santos", List.of());
            Customer ana = new Customer("Ana", "Paula", List.of());

            itemRepository.saveAll(
                    List.of(
                            camarao, paillard, escondidinho,
                            salada, gateau, pastelPalmito, pasteFile,
                            tilapia, cookie, pave, lasanha, burger,
                            arroz, cocktail, fritas, polvo,
                            saladaOriental, pizza, peixada, bolo
                    )
            );
            customerRepository.saveAll(List.of(maria, joao, ana));
        };
    }

}
