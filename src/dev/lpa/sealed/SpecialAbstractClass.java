package dev.lpa.sealed;

// Can add permits nested class.
public sealed abstract class SpecialAbstractClass permits FinalKid, NonSealedKid, SealedKid, SpecialAbstractClass.Kid {

    // This doesn't have a permit clause in SAC
    // That's ok bc it's a nested class, this is allowed
    // Now, we've added a permits clause anyway for clarity
    final class Kid extends SpecialAbstractClass{



    }

}
