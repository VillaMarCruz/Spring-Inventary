package xyz.lytasoft.springinventary.models.products;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "details", nullable = false, length = 100)
    private String details;

    @Column(name = "status", nullable = false)
    private int status;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "category_fkey"), name = "category_id")
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "presentation_fkey"), name = "presentation_id")
    private PresentationEntity presentation;

}
