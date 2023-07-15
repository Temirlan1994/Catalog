package entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "option")
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private String option;

    @OneToMany(mappedBy = "option")
    private List<Value> value;

    public Long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public String getOption() {
        return option;
    }

    public List<Value> getValue() {
        return value;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public void setValue(List<Value> value) {
        this.value = value;
    }
}
