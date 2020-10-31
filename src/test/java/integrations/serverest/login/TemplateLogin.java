package integrations.serverest.login;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TemplateLogin {

  @Builder.Default private final String email = "fulano@qa.com";
  @Builder.Default private final String password = "teste";
}
