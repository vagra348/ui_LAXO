package tests;

import pages.DomenInputPage;
import pages.OrdersPages.MainOrdersPage;
import pages.OrdersPages.OrderCardPage;
import core.BaseSeleniumTest;
import helpers.StringModifier;
import helpers.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class OrdersTests extends BaseSeleniumTest {
    @Test
    @DisplayName("Создание сделки с главной страницы")
    public void add_order(){
        String new_order_name = StringModifier.unique_string("New_order_");
        String new_order_URL_substr = "https://"+TestData.domen_value+".laxo.one/orders/view/";
        String new_order_url_value = mainOrdersPage
                .open_add_order_card()
                .add_new_order(new_order_name)
                .get_order_card_URL();
        assertThat(new_order_url_value).contains(new_order_URL_substr);
    }

    @Test
    @DisplayName("Редактирование названия из карточки сделки")
    public void edit_order_card(){
        OrderCardPage edit_order_name = mainOrdersPage
                .open_order();
        String last_name = edit_order_name.get_order_card_name();
        edit_order_name.edit_order()
                .edit_order_name()
                .save_changes();
        String new_name = edit_order_name.get_order_card_name();
        assertThat(last_name).isNotEqualTo(new_name);
    }
}
