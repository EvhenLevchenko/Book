package dto;


import domain.Book;
import domain.Genre;
import lombok.Builder;
import lombok.Data;


@Data
@Builder(toBuilder = true)//this update model
public class BookDto {

    private String title;
    private int year;
    private Genre genre;

    public static Book fromDto(BookDto bookDto) {
        return Book.builder()
                .title(bookDto.title)
                .year(bookDto.year)
                .genre(bookDto.genre)
                .build();
    }

    public  static BookDto toDto(Book book){
        return BookDto.builder()
                .title(book.getTitle())
                .year(book.getYear())
                .genre(book.getGenre())
                .build();
    }

}
