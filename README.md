1. 의존성 추가
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'

2. Repository 인터페이스 추가
Page<Board> findAll(Pageable pageable);

3. BoardServiceImpl 추가
public Page<BoardResponseDto> getAllBoards
private BoardResponseDto convertToDto(Board board)

4. 게시판 컨트롤러 추가
@GetMapping("/paging")
public Page<BoardResponseDto> getAllBoards
