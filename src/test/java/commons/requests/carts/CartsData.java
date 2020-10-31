package commons.requests.carts;

import commons.requests.products.ProductsData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CartsData {

  private ProductsData products;
  private Integer precoTotal;
  private Integer quantidadeTotal;
  private String idUsuario;
  private String _id;
}
