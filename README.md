# DDoS Attack Program

Este é um programa de ataque DDoS desenvolvido para fins educacionais. Ele realiza um ataque de negação de serviço distribuído (DDoS) contra um servidor alvo.

## Funcionamento

O programa cria um número especificado de threads que enviam solicitações HTTP para o servidor alvo de forma simultânea. Cada thread é responsável por um número máximo de conexões por ciclo de ataque. 
O ciclo de ataque é controlado por uma taxa de ataque por segundo, permitindo ajustar a intensidade do ataque.

## Características

- Utiliza várias threads para distribuir as solicitações de ataque.
- Implementa o cabeçalho Keep-Alive para manter as conexões HTTP abertas e reutilizá-las para envio de múltiplas solicitações.
- Permite configurar proxies para distribuir o ataque e evitar bloqueios.
- Possui um mecanismo de controle de velocidade para otimizar a taxa de envio de solicitações com base na resposta do servidor.
- Desenvolvido apenas para fins educacionais e de aprendizado sobre segurança cibernética.

## Por que é Eficiente

Este programa é eficiente por várias razões:

1. **Uso de Threads:** O uso de threads permite paralelizar o ataque, aumentando a eficiência ao enviar múltiplas solicitações simultaneamente.
2. **Reutilização de Conexões:** O cabeçalho Keep-Alive mantém as conexões HTTP abertas, evitando o custo de abrir e fechar conexões repetidamente.
3. **Controle de Velocidade:** O controle de velocidade ajusta a taxa de envio de solicitações com base na resposta do servidor, evitando sobrecarregar o servidor alvo.
4. **Configuração de Proxies:** O uso de proxies distribui o ataque entre vários IPs, dificultando o bloqueio por parte do servidor alvo.
5. **Monitoramento e Ajustes:** O programa permite ajustes dinâmicos e monitoramento do uso de recursos, otimizando a eficiência do ataque.

## Aviso Legal

Este programa foi desenvolvido apenas para fins educacionais e não deve ser utilizado para realizar ataques DDoS contra sistemas ou redes sem autorização prévia. O uso indevido de tais técnicas pode resultar em sérias consequências legais e éticas.

## Autor

Este programa foi desenvolvido por Kaique Fernando como parte de um projeto educacional sobre segurança cibernética.

