Feign 테스트 

- REST 서버 
  - https://jsonplaceholder.typicode.com/
- 테스트 범위
  - GET, POST, DELETE 요청 
  - 요청 Body
    - 단순 파라미터, JSON Body 
    - 파일 업로드는 포함되지 않음 
  - 헤더 설정 
    - Content-Type 
  - 실패 응답 시 예외처리
    - 400 ~ 500 코드 수신 시, 예외처리 (ErrorDecoder) 타게됨 
    - 300번 대역 응답은 확인 안해봄 