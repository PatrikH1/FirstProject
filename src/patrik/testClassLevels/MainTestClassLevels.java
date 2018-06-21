package patrik.testClassLevels;

public class MainTestClassLevels {
}


//    public void applicera(List<AbIuaIndividuppgift> individuppgifter, AbIuaAckumuleradIndividuppgift amuBas) {
//        AbIuaAckumuleradIndividuppgV1 amu = (AbIuaAckumuleradIndividuppgV1) amuBas;
//        List<AbIuaIndividuppgift> filtreradeindividuppgifter = filtrera(individuppgifter);
//        if (filtreradeindividuppgifter.size() > 0) {
//            ackumulera(filtreradeindividuppgifter, amu);
//            adderaSparning(filtreradeindividuppgifter, amu);
//        }
//    }
//
//    private List<AbIuaIndividuppgift> filtrera(List<AbIuaIndividuppgift> individuppgifter) {
//        return individuppgifter.stream().filter(iu -> filterSkattefalt(iu))
//                .filter(iu -> filterVillkor(iu))
//                .collect(Collectors.toList());
//    }
//
//    protected abstract boolean filterSkattefalt(AbIuaIndividuppgift iu);
//
//    protected abstract boolean filterVillkor(AbIuaIndividuppgift iu);
//
//    protected abstract void ackumulera(List<AbIuaIndividuppgift> iuLista, AbIuaAckumuleradIndividuppgV1 amu);