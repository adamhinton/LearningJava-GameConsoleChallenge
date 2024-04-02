package dev.lpa.sealed;

// Must permit anything that extends it
public sealed class SealedKid extends SpecialAbstractClass{

    final class GrandKid extends SealedKid{}

}
