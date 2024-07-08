package com.example.smartproperty;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link search_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class search_fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    BottomSheetDialogFragment bottomsheetFragment = new bottomsheet_fragment();
    TextInputEditText cityEditText;
    private TextView filtersTextView, wantTextView, propertyTypeTextView, priceRangeTextView,
            areaTypeTextView, areaRangeTextView, numberOfBedroomsTextView, numberOfBathroomsTextView;
    private NestedScrollView nestedScrollView;
    private LinearLayout mainLinearLayout;
    private ChipGroup buyRentChipGroup, propertyTypeChipGroup, homesTypeChipGroup, plotsTypeChipGroup,
            commercialTypeChipGroup, bedroomsChipGroup, bathroomsChipGroup;
    private Chip chipRent, chipBuy, chipHome, chipPlot, chipCommercial;
    private Chip houseChip, roomChip, upperPortionChip, lowerPortionChip, flatChip, farmHouseChip;
    private Chip residentialPlotChip, commercialPlotChip, plotFileChip, agriculturalLandChip, industrialLandChip;
    private Chip officeChip, shopChip, warehouseChip, factoryChip, otherChip;
    private TextInputLayout cityTextInputLayout, locationTextInputLayout, minPriceTextInputLayout, maxPriceTextInputLayout,
            areaTypeTextInputLayout, minAreaTextInputLayout, maxAreaTextInputLayout;
    private TextInputEditText cityTextInputEditText, locationTextInputEditText, minPriceTextInputEditText,
            maxPriceTextInputEditText, minAreaTextInputEditText, maxAreaTextInputEditText;
    private AutoCompleteTextView areaTypeAutoCompleteTextView;
    private MaterialButton searchButton;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public search_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment search_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static search_fragment newInstance(String param1, String param2) {
        search_fragment fragment = new search_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search_fragment, container, false);

        cityEditText = view.findViewById(R.id.buttomsheet_button); // Assuming the correct ID is cityEditText
        buyRentChipGroup = view.findViewById(R.id.buyrent_chip_group);
        propertyTypeChipGroup = view.findViewById(R.id.chip_group_property_type);
        homesTypeChipGroup = view.findViewById(R.id.homes_type_chip_group);
        plotsTypeChipGroup = view.findViewById(R.id.plots_type_chip_group);
        commercialTypeChipGroup = view.findViewById(R.id.commercial_type_chip_group);
        bedroomsChipGroup = view.findViewById(R.id.chip_group_bedrooms);
        bathroomsChipGroup = view.findViewById(R.id.chip_group_bbathrooms);

        chipRent = view.findViewById(R.id.chip_rent);
        chipBuy = view.findViewById(R.id.chip_buy);
        chipHome = view.findViewById(R.id.chip_home);
        chipPlot = view.findViewById(R.id.chip_plot);
        chipCommercial = view.findViewById(R.id.chip_commercial);

        houseChip = view.findViewById(R.id.house_chip);
        roomChip = view.findViewById(R.id.room_chip);
        upperPortionChip = view.findViewById(R.id.upperportion_chip);
        lowerPortionChip = view.findViewById(R.id.lowerportion_chip);
        flatChip = view.findViewById(R.id.flat_chip);
        farmHouseChip = view.findViewById(R.id.farmhouse_chip);

        residentialPlotChip = view.findViewById(R.id.residentialplot_chip);
        commercialPlotChip = view.findViewById(R.id.commercialplot_chip);
        plotFileChip = view.findViewById(R.id.plotfile_chip);
        agriculturalLandChip = view.findViewById(R.id.agriculturalland_chip);
        industrialLandChip = view.findViewById(R.id.industrialland_chip);

        officeChip = view.findViewById(R.id.office_chip);
        shopChip = view.findViewById(R.id.shop_chip);
        warehouseChip = view.findViewById(R.id.warehouse_chip);
        factoryChip = view.findViewById(R.id.factory_chip);
        otherChip = view.findViewById(R.id.other_chip);


        locationTextInputEditText = view.findViewById(R.id.input_location);
        minPriceTextInputEditText = view.findViewById(R.id.input_min_price);
        maxPriceTextInputEditText = view.findViewById(R.id.input_max_price);
        minAreaTextInputEditText = view.findViewById(R.id.input_min_area);
        maxAreaTextInputEditText = view.findViewById(R.id.input_max_area);

        areaTypeAutoCompleteTextView = view.findViewById(R.id.input_area_type);

        searchButton = view.findViewById(R.id.button_search);

        cityEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomsheetFragment.show(getParentFragmentManager(), bottomsheetFragment.getTag());
            }
        });

        ((bottomsheet_fragment) bottomsheetFragment).setOnCitySelectedListener(new bottomsheet_fragment.OnCitySelectedListener() {
            @Override
            public void onCitySelected(String city) {
                cityEditText.setText(city);
            }
        });


        propertyTypeChipGroup.setOnCheckedStateChangeListener(new ChipGroup.OnCheckedStateChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull ChipGroup group, @NonNull List<Integer> checkedIds) {
                if (!checkedIds.isEmpty()) {
                    int checkedId = checkedIds.get(0);
                    homesTypeChipGroup.setVisibility(View.GONE);
                    plotsTypeChipGroup.setVisibility(View.GONE);
                    commercialTypeChipGroup.setVisibility(View.GONE);
                    if (checkedId == R.id.chip_home) {
                        homesTypeChipGroup.setVisibility(View.VISIBLE);
                    } else if (checkedId == R.id.chip_plot) {
                        plotsTypeChipGroup.setVisibility(View.VISIBLE);
                    } else if (checkedId == R.id.chip_commercial) {
                        commercialTypeChipGroup.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        return view;
    }
}
