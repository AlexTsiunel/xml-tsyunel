package com.company.xml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeRepositoryInMemory implements Repository<Employee> {
    private static final Map<Long, Employee> data = new HashMap<>();
    static {
        data.put(1L, new Employee(1L, "Roland", "Katz", "Roland_Katz@wanadoo.lk", "+1 (674) 350-725", "f1d20bc1c9a6c30193cfc29e25766156b8729e24", "upbeat construction", (byte) 1));
        data.put(2L, new Employee(2L, "Mason", "Daniel","Mason_Daniel@uol.sk", "+375292222222", "6193827bb0ffa72a710e20ab0a0dd7f6a71ee243", "frightening dinner", (byte) 4));
        data.put(3L, new Employee(3L, "Wilfredo", "Scarborough","Wilfredo_Scarborough@rediffmail.gy", "+1 (429) 984-349", "+1 (711) 307-729", "19b8d21ff1beb9025f8ad7af829b0294211c6b61", (byte) 2));
        data.put(4L, new Employee(4L, "Ellis", "Parra","Ellis_Parra@orange.bt", "+1 (740) 277-784", "87b6c20d0b38bae43d8db3338159709b03aef6e6", "wiggly examination", (byte) 1));
        data.put(5L, new Employee(5L, "Heriberto", "Mcallister","Heriberto_Mcallister@live.py", "+1 (520) 622-125", "44ec0b6ecc10bfd077ce0fd22d64d21206285f92", "coherent restaurant", (byte) 3));
        data.put(6L, new Employee(6L, "Cory", "Gibbons","Cory_Gibbons@msn.nl", "+1 (974) 907-708", "cfeab09d84798f9b800ec21cd7f94cc6e86751c2", "lopsided success", (byte) 1));
        data.put(7L, new Employee(7L, "Antwan", "Jack","+1 (406) 122-626", "+375297777777", "551164f8b4f89808a5ca65d772b6b19bda0e9083", "productive uncle", (byte) 2));

    }

    @Override
    public Employee getById(Long id) {
        return data.get(id);
    }

    @Override
    public List<Employee> getAll() {
        return new ArrayList<>(data.values());
    }
}