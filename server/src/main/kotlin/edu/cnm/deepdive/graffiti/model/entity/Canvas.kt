package edu.cnm.deepdive.graffiti.model.entity

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.time.Instant
import java.util.*

@Entity
open class Canvas(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "canvas_id")
    val id: Long? = null,

    @Column(nullable = false, updatable = false, unique = true)
    var externalKey: UUID? = null,

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id", nullable = false, updatable = false)
    var owner: User? = null,

    @Column(nullable = false, updatable = false)
    var width: Int,

    @Column(nullable = false, updatable = false)
    var height: Int,

    @Column(nullable = false, updatable = false, columnDefinition = "DEFAULT -1")
    var backgroundColor: Int = -1,

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    var created: Instant? = null,

    @OneToMany(mappedBy = "canvas", fetch = FetchType.LAZY)
    @OrderBy("id ASC")
    var brushStrokes: MutableList<BrushStroke> = mutableListOf(),
) {
    override fun equals(other: Any?): Boolean =
        when {
            other === null -> false
            other !is Canvas -> false
            other === this -> true
            else -> (other.id != null && other.id == this.id)
        }

    override fun hashCode(): Int =
        javaClass.hashCode()


    override fun toString(): String =
        "Canvas(id=$id, externalKey=$externalKey, owner=$owner, width=$width, height=$height, backgroundColor=$backgroundColor, created=$created)"

    @PrePersist
    private fun generateAttributeValues() {
        externalKey = UUID.randomUUID()
    }
}