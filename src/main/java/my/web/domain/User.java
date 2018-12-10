package my.web.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

/**
 * Список пользователей
 */
@Entity
@Table(name = "USR")
public class User implements UserDetails {

    /* Уникальный ID пользователя */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(unique = true)
    private long row_id;

    /* Уникальный Login пользователя */
    @Column(unique = true, nullable = false, length = 40)
    private String username;

    /* Уникальный ID пользователя поддержки */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Support_ID")
    private User support;

    /* Пароль пользователя */
    @Column(nullable = false, length = 20)
    private String password;

    /* Фамилия пользователя */
    @Column(nullable = false, length = 40)
    private String firstName;

    /* Имя пользователя */
    @Column(nullable = false, length = 40)
    private String lastName;

    /* Email пользователя */
    @Column(unique = true, nullable = false, length = 60)
    private String email;

    /* Страна пользователя */
    @Column(length = 40)
    private String country;

    /* Город пользователя */
    @Column(length = 40)
    private String city;

    /* Адрес пользователя */
    @Column(length = 70)
    private String address;

    /* Телефон пользователя */
    @Column(length = 24)
    private String phone;

    /* Счет пользователя */
    @Column
    private Long score;

    /* Активность пользователя */
    private boolean active;

    /* Ссылка на аватар пользователя */
    private String avatarName;

    /* Список ролей пользователя */
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "USER_ROW_ID"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public long getRow_id() {
        return row_id;
    }

    public void setRow_id(long row_id) {
        this.row_id = row_id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getAvatarName() {
        return avatarName;
    }

    public void setAvatarName(String avatarName) {
        this.avatarName = avatarName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    public boolean isAdmin() {
        return roles.contains(Role.ADMIN);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public User getSupport() {
        return support;
    }

    public void setSupport(User support) {
        this.support = support;
    }

    public String getSupportUserName(){
        return support != null ? support.getUsername() : "";
    }
}
