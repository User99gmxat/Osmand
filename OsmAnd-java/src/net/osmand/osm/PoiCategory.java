package net.osmand.osm;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;


public class PoiCategory extends PoiFilter {

	private List<PoiFilter> poiFilters = new ArrayList<PoiFilter>();
	private int regId;
	private String defaultTag;

	public PoiCategory(MapPoiTypes registry, String keyName, int regId) {
		super(registry, null, keyName);
		this.regId = regId;
	}

	public void addPoiType(PoiFilter poi) {
		poiFilters.add(poi);
	}

	public List<PoiFilter> getPoiFilters() {
		return poiFilters;
	}
	
	public String getDefaultTag() {
		if(defaultTag == null) {
			return keyName;
		}
		return defaultTag;
	}
	
	public void setDefaultTag(String defaultTag) {
		this.defaultTag = defaultTag;
	}
	
	public Map<PoiCategory, LinkedHashSet<String>> putTypes(
			Map<PoiCategory, LinkedHashSet<String>> acceptedTypes) {
		acceptedTypes.put(this, null);
		addReferenceTypes(acceptedTypes);
		return acceptedTypes;
	}

	
	public boolean isWiki() {
		return keyName.equals(MapPoiTypes.OSM_WIKI_CATEGORY);
	}


	public int ordinal() {
		return regId;
	}

	

}
