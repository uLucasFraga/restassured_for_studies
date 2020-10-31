package commons.requests.products;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ProductsData {

  private String nome;
  private Integer preco;
  private String descricao;
  private Integer quantidade;
  private String _id;
}
