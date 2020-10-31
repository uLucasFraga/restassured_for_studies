package commons.requests.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UsersData {

  private String nome;
  private String email;
  private String password;
  private String administrador;
  private String _id;
}
