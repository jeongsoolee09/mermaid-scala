package mermaid.Sequence

sealed trait Element
case class Base(kind: BaseKind) extends Element
case class Inductive(kind: InductiveKind) extends Element

sealed trait BaseKind
case class SubComponent(kind: SubcomponentKind) extends BaseKind
case class Label(kind: LabelKind) extends BaseKind
case class Message(kind: ArrowKind) extends BaseKind
case class Note(kind: NoteKind) extends BaseKind

sealed trait SubcomponentKind
case class Actor(name: String) extends SubcomponentKind
case class Color(r: Int, g: Int, b: Int, a: Float) extends SubcomponentKind

sealed trait LabelKind
case class Autonumber() extends LabelKind
case class Participants(participants: List[Actor]) extends LabelKind
case class Activate(actor: Actor) extends LabelKind
case class Deactivate(actor: Actor) extends LabelKind

sealed trait ArrowKind
case class Solid(kind: HeadKind) extends ArrowKind
case class Dotted(kind: HeadKind) extends ArrowKind

sealed trait HeadKind
case class Line(from: Actor, to: Actor, message: String, activate: Boolean, deactivate: Boolean) extends HeadKind
case class Arrow(from: Actor, to: Actor, message: String, activate: Boolean, deactivate: Boolean) extends HeadKind
case class Cross(from: Actor, to: Actor, message: String, activate: Boolean, deactivate: Boolean) extends HeadKind
case class Open(from: Actor, to: Actor, message: String, activate: Boolean, deactivate: Boolean) extends HeadKind

sealed trait NoteKind
case class Left(actor: Actor, note: String) extends NoteKind
case class Right(actor: Actor, note: String) extends NoteKind
case class Over(actor: Actor, note: String) extends NoteKind

sealed trait InductiveKind extends Element
case class Block(kind: BlockKind) extends InductiveKind
case class Clause(kind: ClauseKind) extends InductiveKind
case class SequenceDiagram() extends InductiveKind

sealed trait BlockKind
case class Loop(label: String) extends BlockKind
case class Highlight(color: Color) extends BlockKind
case class Alternative(condition: String) extends BlockKind
case class Parallel(description: String) extends BlockKind
case class Optional(description: String) extends BlockKind

sealed trait ClauseKind
case class Else(label: String) extends ClauseKind
case class And(label: String) extends ClauseKind