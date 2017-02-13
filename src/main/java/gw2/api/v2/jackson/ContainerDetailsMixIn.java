package gw2.api.v2.jackson;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import gw2.api.v2.items.ContainerDetails;

@JsonDeserialize(builder = ContainerDetails.Builder.class)
public interface ContainerDetailsMixIn {
}